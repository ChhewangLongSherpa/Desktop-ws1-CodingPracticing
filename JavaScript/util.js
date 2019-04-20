// https://gist.github.com/hk-skit/a82c4d9bf1c95f066e4f7e37edf3c81d
// https://medium.com/@smellycode/js-one-liners-8bc0a6af2345?sk=a9295a05aef9e514e137fca7eeb89cd1
// JavaScript One-Liners
// Date: 03/04/2019

//REMOVE DUPLICATES
//Using filter
const removeDuplicates = arr => arr.filter((item, index) => index === arr.indexOf(item));

//Using spread operator
const removeDuplicates1 = array => [ ... new Set(array)];

//Using Array.from method
const removeDuplicates2 = array => Array.from(new Set(array));

//FLATTEN ARRAY
// i.e.
// 2-dimensional array == [[1, 2, 3], [4, 5, 6]]
// After flattening == [1, 2, 3, 4, 5, 6]
// Multi-dimentional array  == [1, [2, [3, 4, [5], 6], 7], 8], 9]
// After flattening == [1, 2, 3, 4, 5, 6, 7, 8, 9]
//Using spread operator
//Only flatten array at one level/dimension
const flatten = array => [].concat(... array);

//Fully flatten an array
const flatten =
  arr => arr.reduce((fArr, item) =>
    fArr.concat(Array.isArray(item) ? flatten(item) : item), []);


//Merge Arrays
//Using spread operator and Array.concat method
const merge = ( ... arrays ) => [].concat( ... arrays );

// PIPE == output of one function is the input to another function
// Pipe using Function Composition -- naive approach
const pipe = ( ... fns ) => arg => fns.reduce((v, fn) => fn(v), arg);

//RANGE Function
//Using Array.from
//Generate range from start to end (exclusive)
const range = (start, end, step = 1) =>
  Array.from({length: Math.ceil((end - start) / step)}, (_, i) =>
    start + i *step);

//COLOR function
const hexColor = () =>
  '#' + Math.floor(Math.random(Math.random() * 0xffffff).toString(16).padEnd(6,'0');
