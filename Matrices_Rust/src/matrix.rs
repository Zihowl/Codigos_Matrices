// src/matrix.rs
pub struct Matrix {
    rows: usize,
    cols: usize,
    data: Vec<Vec<i32>>,
    index: Option<usize>,
}

impl Matrix {
    pub fn create(index: usize) -> Matrix {
        use crate::input::get_integer;
        println!();
        let rows = loop {
            let r = get_integer(&format!("Ingrese el número de filas de la matriz {}: ", index));
            if r > 0 { break r as usize } else { println!("El número de filas debe ser positivo."); }
        };
        let cols = loop {
            let c = get_integer(&format!("Ingrese el número de columnas de la matriz {}: ", index));
            if c > 0 { break c as usize } else { println!("El número de columnas debe ser positivo."); }
        };
        let mut data = vec![vec![0; cols]; rows];
        for i in 0..rows {
            for j in 0..cols {
                let val = get_integer(&format!("Ingrese el elemento [{}][{}]: ", i, j));
                data[i][j] = val;
            }
        }
        Matrix { rows, cols, data, index: Some(index) }
    }

    pub fn new(rows: usize, cols: usize) -> Matrix {
        Matrix { rows, cols, data: vec![vec![0; cols]; rows], index: None }
    }

    pub fn rows(&self) -> usize { self.rows }
    pub fn columns(&self) -> usize { self.cols }

    pub fn add(&self, other: &Matrix) -> Matrix {
        if self.rows != other.rows || self.cols != other.cols {
            panic!("Las matrices deben tener las mismas dimensiones para sumar");
        }
        let mut res = Matrix::new(self.rows, self.cols);
        for i in 0..self.rows {
            for j in 0..self.cols {
                res.data[i][j] = self.data[i][j] + other.data[i][j];
            }
        }
        res
    }

    pub fn subtract(&self, other: &Matrix) -> Matrix {
        if self.rows != other.rows || self.cols != other.cols {
            panic!("Las matrices deben tener las mismas dimensiones para restar");
        }
        let mut res = Matrix::new(self.rows, self.cols);
        for i in 0..self.rows {
            for j in 0..self.cols {
                res.data[i][j] = self.data[i][j] - other.data[i][j];
            }
        }
        res
    }

    pub fn multiply(&self, other: &Matrix) -> Matrix {
        if self.cols != other.rows {
            panic!("Las matrices deben tener dimensiones compatibles para multiplicar");
        }
        let mut res = Matrix::new(self.rows, other.cols);
        for i in 0..self.rows {
            for j in 0..other.cols {
                let mut sum = 0;
                for k in 0..self.cols {
                    sum += self.data[i][k] * other.data[k][j];
                }
                res.data[i][j] = sum;
            }
        }
        res
    }

    pub fn display(&self) {
        if let Some(idx) = self.index {
            println!("\nMatriz {}:", idx);
        } else {
            println!("\nMatriz resultante:");
        }
        for i in 0..self.rows {
            print!("[");
            for j in 0..self.cols {
                print!("{} ", self.data[i][j]);
            }
            println!("]");
        }
        println!();
    }
}