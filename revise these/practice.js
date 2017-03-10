function pizza(type, fun){
    console.log(type + " is deleicis");
    fun(type);
}

function eat(piz){
    console.log("I am eating " + piz + " pizza.");
}

function cook(p){
    console.log("I am cooking " + p + " pizza.");
}

pizza("maccaroni", cook);

var ar = [-9, 5, -11, 31, 111, 12, 333, 34, 2, 1, 3, 2, 98, 7];
ar.sort();
console.log(ar)
ar.sort(function(a, b){
    if (a < b) return -1;
    return (a > b)?1:0;
})
console.log(ar)

var rec = {
    width: 50,
    color: 'red',
    length: 15
}

function rec(w, c, l){
    this.w = w;
    this.c = c;
    this.l = l;
}


function disp(e, i, a){
    console.log("index is " + i  + " and ele is " + a[i]);
}
var arr = ['cat', 'dog', 'apple'];
arr.forEach(disp);

var num = [3, 4, 5];
//num.forEach(addTwo);
num.map(disp);
two = num.map(function(e, i, a){
    return e + e;
})
console.log(two);
console.log(num);
sum = num.reduce(function(a, b){
    return a + b;
})
console.log(sum);