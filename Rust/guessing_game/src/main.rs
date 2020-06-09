use rand::Rng;
use std::io;
use std::cmp::Ordering;

fn main() {
    println!("Guess the number between 1 and 100");
    println!("Input your guess");
    
    let mut guess = String::new();
    let secret_number = rand::thread_rng().gen_range(1, 100);
    
    io::stdin().read_line(&mut guess).expect("Error reading");
    let guess:u32 = guess.trim().parse().expect("Please Enter a Number");

    println!("You have guessed {}", guess);


    match guess.cmp(&secret_number){
        Ordering::Less => println!("Too small!"),
        Ordering::Greater => println!("Too big!"),
        Ordering::Equal => println!("You win!"),
    }
    println!("The Number was {}", secret_number);
}
