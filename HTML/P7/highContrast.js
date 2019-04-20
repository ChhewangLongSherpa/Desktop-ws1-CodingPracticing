// Set High contrast items
// Source: https://css-tricks.com/css-variables-calc-rgb-enforcing-high-contrast-colors/
// Date: 03/04/2019
var styles = getComputedStyle( document.body );
var root = document.documentElement;
var range = document.querySelectorAll('.range');

function setDataVal(element) {
  element.setAttribute('data-value', element.value );
}

for ( var i = 0; i < range.length; i++ ) {
  var rangeItem = range[i];
  var initialRangeValue = parseInt( styles.getPropertyValue('--' + rangeItem.name));

  rangeItem.value = initialRangeValue;
  setDataVal(rangeItem);

  rangeItem.addEventListener('input', function() {
    root.style.setProperty('--' + this.name, this.value);
    setDataVal(this);
  })
}
