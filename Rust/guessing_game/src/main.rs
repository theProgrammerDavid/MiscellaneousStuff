use rand::Rng;
use std::cmp::Ordering;
use std::io;

const SOME_CONSTANT:u32 = 100_000;

fn main() {
    println!("The constant is {}\n\n", SOME_CONSTANT);
    println!("Guess the number between 1 and 100");
    loop {
        println!("Input your guess");

        let secret_number = rand::thread_rng().gen_range(1, 100);
        let mut guess = String::new();

        // io::stdin().read_line(&mut guess).expect("Error reading");
        // let guess: u32 = guess.trim().parse().expect("Please Enter a Number");

        io::stdin().read_line(&mut guess).expect("Error reading");

        let guess: u32 = match guess.trim().parse() {
            Ok(number) => number,
            Err(_) => {
                println!("Invalid Number");
                continue;
            }
        };

        println!("You have guessed {}", guess);

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
        println!("The Number was {}", secret_number);
    }
}
