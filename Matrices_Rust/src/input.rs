// src/input.rs
use std::io::{self, Write};

pub fn get_integer(prompt: &str) -> i32 {
    loop {
        print!("{}", prompt);
        io::stdout().flush().ok();
        let mut input = String::new();
        if io::stdin().read_line(&mut input).is_err() {
            println!("Error leyendo entrada. Intente de nuevo.");
            continue;
        }
        match input.trim().parse::<i32>() {
            Ok(n) => return n,
            Err(_) => {
                println!("Entrada inválida, intente de nuevo.");
            }
        }
    }
}

pub fn get_string(prompt: &str) -> String {
    print!("{}", prompt);
    io::stdout().flush().ok();
    let mut s = String::new();
    io::stdin().read_line(&mut s).ok();
    s.trim().to_string()
}