#[derive(Default)]
struct MyQueue {
    stack: Vec<i32>,
    reversed_stack: Vec<i32>,
}
impl MyQueue {
    fn new() -> Self {
        Self::default()
    }

    fn push(&mut self, x: i32) {
        self.stack.push(x);
    }

    fn pop(&mut self) -> i32 {
        Self::populate_reversed_stack(self);
        self.reversed_stack.pop().unwrap()
    }

    fn peek(&mut self) -> i32 {
        Self::populate_reversed_stack(self);
        *self.reversed_stack.last().unwrap()
    }

    fn empty(&self) -> bool {
        self.stack.is_empty() && self.reversed_stack.is_empty()
    }

    fn populate_reversed_stack(&mut self) {
        if self.reversed_stack.is_empty() {
            while let Some(v) = self.stack.pop() {
                self.reversed_stack.push(v);
            }
        }
    }
}
