// src/main.rs
mod matrix;
mod input;

use matrix::Matrix;
use input::get_integer;

fn main() {
    println!("\n=== Operaciones con Matrices ===");
    
    let m1 = Matrix::create(1);
    m1.display();
    
    let m2 = Matrix::create(2);
    m2.display();

    loop {
        println!("Operaciones disponibles:");
        if m1.rows() == m2.rows() && m1.columns() == m2.columns() {
            println!("1. Sumar");
            println!("2. Restar");
            println!("3. Multiplicar\n");
        } else if m1.columns() == m2.rows() {
            println!("3. Multiplicar\n");
        } else {
            println!("No hay operaciones disponibles entre las matrices. Saliendo del programa.");
            return;
        }

        let option = get_integer("Seleccione una operación: ");
        
        match option {
            1 => {
                let result = m1.add(&m2);
                result.display();
            }
            2 => {
                let result = m1.subtract(&m2);
                result.display();
            }
            3 => {
                let result = m1.multiply(&m2);
                result.display();
            }
            _ => {
                println!("Opción inválida, intente de nuevo:");
                continue;
            }
        }

        let response = input::get_string("¿Desea realizar otra operación? (s/n): ");
        if response.to_lowercase() != "s" {
            println!("Saliendo del programa.");
            break;
        }
    }
}