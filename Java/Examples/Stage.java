/* See README.TXT for information about this software 
https://courses.cs.washington.edu/courses/cse142/01au/dist/Stage.java
*/
package uwcse.animation;

/** 
    A Stage represents a collections of Actors (active shapes) and
    Props (unmoving shapes).  It repeatedly prods each actor to take a
    step.  It also listens for keyboard and mouse inputs, and passes
    them to the given event handler object.  Actors and Props are
    drawn on the underlying GWindow in the order they were added to
    the stage. */

import uwcse.graphics.*;
import java.util.*;

public class Stage {
  /** The window on which all the actors and props are drawn. */
  private GWindow window;

  /** A list of Actor objects.  Actors receive periodic "doAction"
      messages. */
  private ArrayList actors;

  /** A list of Prop objects.  Props don't move. */
  private ArrayList props;

  /** Amount of time to pause between each round of animation, in ms. */
  private int timeForOneRound = 50;

  /** Whether we're in the middle of a round of animation. */
  private boolean animating;

  /** A list of actors that have been added in the middle of a round
      of animation.  They will be moved to the actors list when the
      round of animation finishes. */
  private ArrayList newActors;

  /** A list of props that have been added in the middle of a round of
      animation.  They will be moved to the props list when the round
      of animation finishes. */
  private ArrayList newProps;

  /** A list of actors that have been removed in the middle of a round
      of animation.  They will be removed from the actors list when the
      round of animation finishes. */
  private ArrayList removedActors;

  /** A list of props that have been removed in the middle of a round of
      animation.  They will be removed from the props list when the round
      of animation finishes. */
  private ArrayList removedProps;

  /** Whether the animation should quit after the current round */
  private boolean quitAnimation;

  /** Whether the animation should suspend after the current round */
  private boolean suspendAnimation;

  /** Whether the each round of animation should appear "atomic" (see
      makeAnimationRoundsAtomic() for more information) */
  private boolean animationRoundsAtomic;


  /** Create a new, empty stage, on the given window. */
  public Stage(GWindow window) {
    this.window = window;
    this.actors = new ArrayList();
    this.props = new ArrayList();
    this.newActors = new ArrayList();
    this.newProps = new ArrayList();
    this.removedActors = new ArrayList();
    this.removedProps = new ArrayList();
    this.animating = false;
    this.quitAnimation = false;
    this.suspendAnimation = false;
    this.animationRoundsAtomic = false;
  }


  /** Return the window of the stage. */
  public GWindow getWindow() {
    return this.window;
  }


  /** Return the width of the stage window. */
  public int getWidth() {
    return this.window.getWindowWidth();
  }

  /** Return the height of the stage window. */
  public int getHeight() {
    return this.window.getWindowHeight();
  }


  /** Make each round of animation "atomic", in that only after all
      the doAction operations are done, and all the graphic changes
      are made, will the final updated scene be displayed.  This can
      be used to make coordinated motions look coordinated, instead of
      having each part move separately.  But don't turn it on while
      you're debugging, because you won't be able to see any motions
      until a whole round of animation is completed! */
  public void makeAnimationRoundsAtomic() {
    this.animationRoundsAtomic = true;
  }


  /** Add a new actor to the stage.  (If in the middle of animating,
      this will take effect only at the end of a round of animation.)
      (You can ignore the synchronized keyword.) */
  public synchronized void addActor(Actor actor) {
    if (this.animating) {
      this.newActors.add(actor);   // remember the actor
    } else {
      this.actors.add(actor);   // remember the actor
    }
    actor.addTo(this.window); // draw it on the GWindow
  }

  /** Add a new prop to the stage.  (If in the middle of animating,
      this will take effect only at the end of a round of animation.)
      (You can ignore the synchronized keyword.) */
  public synchronized void addProp(Prop prop) {
    if (this.animating) {
      this.newProps.add(prop);    // remember the prop
    } else {
      this.props.add(prop);    // remember the prop
    }
    prop.addTo(this.window); // draw it on the GWindow
  }

  /** Remove an actor from the stage.  (If in the middle of animating,
      this will take effect only at the end of a round of animation.)
      (You can ignore the synchronized keyword.) */
  public synchronized void removeActor(Actor actor) {
    if (this.animating) {
      this.removedActors.add(actor);
    } else {
      this.actors.remove(actor);
    }
    actor.removeFromWindow();
  }

  /** Remove a prop from the stage.  (If in the middle of animating,
      this will take effect only at the end of a round of animation.)
      (You can ignore the synchronized keyword.) */
  public synchronized void removeProp(Prop prop) {
    if (this.animating) {
      this.removedProps.add(prop);
    } else {
      this.props.remove(prop);
    }
    prop.removeFromWindow();
  }

  /** Return a list of all the actors.  (This allows the action of an
      actor to depend on what other actors are in the animation.) */
  public ArrayList getActors() {
    return this.actors;
  }

  /** Return a list of all the props.  (This allows the action of an
      actor to depend on what other actors are in the animation.) */
  public ArrayList getProps() {
    return this.props;
  }

  /** Get the current amount of time to pause between rounds of
      animation, in ms. */
  public int getTimeForOneRound() {
    return this.timeForOneRound;
  }

  /** Set the amount of time to pause between rounds of animation, in
      ms. */
  public void setTimeForOneRound(int newTime) {
    this.timeForOneRound = newTime;
  }

  /** Pause between rounds. */
  private void pause() {
    // this uses language features that aren't explained in 142!
    try {
      Thread.sleep(this.timeForOneRound);
    }
    catch (Exception e) {
    }
  }
  
  /** Register the handler object that should be notified if there are
      any input events (e.g., key or mouse button pressed or
      released). */
  public void registerEventHandler(GWindowEventHandler handler) {
    this.window.addEventHandler(handler);
  }

  /** Start delivering timer events to the registered event handler.
      @param interval the interval in milliseconds between timerExpired events.
  */
  public void startTimerEvents(int interval) {
    this.window.startTimerEvents(interval);
  }
  
  /** Stop delivering timer events to the registered event handler. */
  public void stopTimerEvents() {
    this.window.stopTimerEvents();
  }


  /** Make it so that the whole animation application will exit when
      the stage's window is closed. */
  public void quitWhenWindowClosed() {
    this.window.setExitOnClose();
  }


  /** Run one round of the animation. */
  public void animateOneRound() {
    if (this.suspendAnimation) {
      // we were instructed to suspend, i.e. skip over doing the work
      return;
    }

    // remember that we're in the middle of a round of animation.
    // (the synchronized block is to handle situations where we are
    // simultaneously trying to add or remove actors or props; we have to
    // be very careful to manage concurrent updates to the actors & props
    // lists.  'synchronized' is a language feature that isn't
    // explained in 142, so you can ignore the synchronized part and just
    // look at what the body of the synchronized block is doing.)
    synchronized (this) {
      this.animating = true;
    }

    if (this.animationRoundsAtomic) {
      // turn off screen updates until we're done with this round of animation
      this.window.suspendRepaints();
    }

    // loop over all the actors, and ask them to do their thing
    Iterator iter = this.actors.iterator();
    while (iter.hasNext()) {
      Actor actor = (Actor)iter.next();
      actor.doAction(this);
    }

    synchronized (this) {
      // now we're done with this round
      this.animating = false;

      // now remove any old actors and props
      this.actors.removeAll(this.removedActors);
      this.removedActors.clear();
      this.props.removeAll(this.removedProps);
      this.removedProps.clear();

      // now add in any new actors and props
      this.actors.addAll(this.newActors);
      this.newActors.clear();
      this.props.addAll(this.newProps);
      this.newProps.clear();
    }

    // re-enable screen updates now that we're done with this round of
    // animation [do it always, without checking
    // animationRoundsAtomic, just in case there is some sort of
    // concurrent activity that turns off atomic animations in the
    // middle of a round of animation]
    this.window.resumeRepaints();
  }

  /** Run rounds of animation forever.  This method doesn't return
      until animation is quit through a separate event. */
  public void animate() {
    while (true) {
      if (this.quitAnimation) {
        // we were instructed to quit
        return;
      }
      this.animateOneRound();
      this.pause();
    }
  }

  /** Run rounds of animation forever, in the background.  This method
      returns right away, as is needed to run animations from the
      start() method of an applet. */
  // this uses language features that aren't explained in 142!
  public void animateInBackground() {
    new AnimationThread(this).start();
  }
  private class AnimationThread extends Thread {
    private Stage theStage;
    public AnimationThread(Stage stage) {
      this.theStage = stage;
    }
    public void run() {
      this.theStage.animate();
    }
  }

  /** Run a certain number of rounds of animation.
      @param times the number of rounds to run. */
  public void animate(int times) {
    for (int i = 0; i < times; i = i + 1) {
      if (this.quitAnimation) {
        // we were instructed to quit
        return;
      }
      this.animateOneRound();
      this.pause();
    }
  }

  /** Quit the animation loop, if it's running.  (I.e., the animate
      method will return.) */
  public void quitAnimation() {
    this.quitAnimation = true;
    this.stopTimerEvents();
  }

  /** Suspend the animation loop, if it's running.  (But the animation
      method won't return, it will just stop animating until told to
      resume, or quit.) */
  public void suspendAnimation() {
    this.suspendAnimation = true;
  }

  /** Resume the animation loop, if was suspended. */
  public void resumeAnimation() {
    this.suspendAnimation = false;
  }

  /** End the animation and close the GWindow */
  public void close() {
    this.quitAnimation();  // quit animating, in case we're still doing that
    this.window.dispose(); // close the GWindow when we're done
  }

}