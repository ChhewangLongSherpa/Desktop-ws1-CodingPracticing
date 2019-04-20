// Auto High Contrast color
// Source: https://css-tricks.com/css-variables-calc-rgb-enforcing-high-contrast-colors/
var rgb = [255, 0, 0];

function setForegroundColor() {
  var sum = Math.round(((parseInt(rgb[0]) * 299) +
    (parseInt(rgb[1] * 587) +
    (parseInd(rgb[2] * 114)) / 1000 )));
    return (sum > 128) ? 'black' : 'white';
}
