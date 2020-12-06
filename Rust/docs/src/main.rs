fn loop_iter() {
    let a = [10, 20, 30, 40, 50];
    for element in a.iter() {
        println!("value is {}", element);
    }
}

fn for_loop(){
    for number in (1..4).rev(){
        println!("{}!", number);
    }
}

fn main() {
    loop_iter();
    for_loop();
    println!("Hello, world!");
}
