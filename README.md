# E-Commerce Shopping Cart

Java console application that models an online shopping cart.

## Description

The system lets a customer get products, add extras (gift wrap, extended
warranty), choose a discount, and check out. When price or stock changes,
subscribers are notified automatically.

## Patterns used

| Pattern | Type | Where | Author   |
|---|---|---|----------|
| Builder | Creational | `builder/` - customizable products | Yerkenaz |
| Factory Method | Creational | `factory/` - Electronics and Clothing factories | Yerkenaz |
| Strategy | Behavioral | `strategy/` - discount algorithms | Nazerke  |
| Decorator | Structural | `decorator/` - gift wrap, extended warranty | Nazerke  |
| Observer | Behavioral | `observer/` - price and stock notifications | Akarys   |
| Facade | Structural | `facade/` - simple checkout | Akarys   |

## Project structure

```
src/
├── Main.java        (demo of all patterns)
├── builder/         (product, builder, director)
├── factory/         (creator, concrete)
├── decorator/       (component, base, concrete)
├── strategy/        (strategy, concrete, context)
├── observer/        (observer, subject, concrete)
└── facade/          (CheckoutFacade, subsystem)
```

## How patterns work together

Factory creates products using Builder. Decorator adds extras to a product.
ShoppingCart calculates the total using a Strategy. CheckoutFacade handles the
order and Inventory notifies Observers about changes.


## Team

- Yerkenaz Azat: Builder, Factory Method
- Nazerke Bozgulan: Strategy, Decorator
- Akarys Serikkazy: Observer, Facade