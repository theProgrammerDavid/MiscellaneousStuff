use std::io;

fn main() {
    println!("Guess the number");
    println!("Input your guess");
    let mut guess = String::new();
    io::stdin().read_line(&mut guess).expect("Error reading");

    println!("You have guessed {}", guess);
}
