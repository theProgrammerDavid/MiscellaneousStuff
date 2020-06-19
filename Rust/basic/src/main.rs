fn main() {
    let tup : (i32, f64, u8) = (500,6.4,1);
    let (x,y,z) = tup;
    println!("The value of x, y and z are {}, {}, {}",x,y,z);
    println!("First and second values are {} and {} ", tup.0, tup.1);
    println!("Hello, world!");

    //Arrays

    let _a:[i32;5] = [1,2,3,4,5];
    //arrays have a fixed size like tuples

    let _b=[3;5];
    //This creates an array with 5 elements each with value 3

    println!("Value of the function is {}", return_value(5));

    let number = return_value(3);

    if number < 5{
        println!("Number is less than 5");
    }

    let mut counter = 0;

    let result = loop{
        counter += 1;

        if counter == 10{
            break counter*2;

        }
    };

    println!("Counter is {}", result);
}


fn return_value(x:i32) ->i32{
    x+1
}
