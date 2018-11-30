# -*- coding: utf-8 -*-
"""
Created on Tue Feb 16 20:54:25 2016

@author: Shop
"""

def midpt(f,a,b,n):
    h = (b-a)/n
    return h*sum([f(a+(i+0.5)*h) for i range(n) ])
    
def midptv(f,a,b,n):
    h = (b-a)/n
    s = np.linspace(a,b,n)
    return(h*f(s).sum())
    
'''
def G(x):
    su = np.zeros(np.shape(x))
    for i,a in enumerate(x):
        if a < 0 or a > 2:
            su[i]=0
        elif 0 <= a < 1:
            su[i]=a**2
        elif 1 <= a < 2:
            su[i]=(2-a)**2
    return(su)
'''
def G(x):
    return np.piecewise(x,[x<0,(0<=x)&(x<1),(1<=x)&(x<2),x>2],\
    [0,lambda x: x**2,lambda x:(2-x)**2,0])
 

def integralG(n=10000):
    a,b = -1,3
    x = np.linspace(-1,3,n)
    return (G(x).sum())
    
    #Wolfram Alpha
    #Integrate[Piecewise[{{0,x<0},{x^2,0<=x<1},{(2-x)^2,1<=x<2},{0,x>2}}],{x,-1,3}]