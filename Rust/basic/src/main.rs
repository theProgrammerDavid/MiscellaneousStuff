fn main() {
    let tup : (i32, f64, u8) = (500,6.4,1);
    let (x,y,z) = tup;
    println!("The value of x, y and z are {}, {}, {}",x,y,z);
    println!("First and second values are {} and {} ", tup.0, tup.1);
    println!("Hello, world!");

    //Arrays

    let a:[i32;5] = [1,2,3,4,5];
    //arrays have a fixed size like tuples

    let b=[3;5];
    //This creates an array with 5 elements each with value 3

    
}
