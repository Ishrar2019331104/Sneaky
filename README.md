# Sneaky - Word Hunting Game

Sneaky is a 2D word hunting game developed in Java where players explore a world map to collect specific letters forming a word. The current game goal is to find all letters of the word "CLOUD" scattered across the map.

## Game Features

- **Engaging 2D Exploration:** Navigate through a carefully designed map with various terrain features
- **Letter Collection:** Hunt for the specific letters C, L, O, U, D to complete the word
- **Obstacles & Challenges:** 
  - Avoid acid pools that reduce speed and life points
  - Wrong letter collection decreases player health
  - Collect insects to gain speed boosts
- **Life System:** Player has 3 lives that decrease when interacting with harmful objects
- **Animated Sprites:** Character animations in multiple directions
- **Sound Effects:** Various sound effects for different interactions
- **Simple UI:** Track your collected letters and remaining lives

## Controls

- **Arrow Keys:** Move the character up, down, left, right
- **Space Bar:** Pause/Resume game
- **Enter:** Select menu options

## Game States

1. **Title Screen:** Main menu with options to play, view rules or exit
2. **Play State:** Active gameplay where you search for letters
3. **Pause State:** Pause the current game
4. **Win State:** Displayed when all letters are collected
5. **Game Over State:** Shown when player loses all lives or speed reduces to zero

## Technical Implementation

- Built using Java with Swing for UI components
- Utilizes a tile-based map system
- Object-oriented design with inheritance for game entities
- Collision detection system for player-object interactions
- Sound management system for music and effects

## Setup & Installation

### Requirements

- Java Development Kit (JDK) 8 or higher
- IDE (IntelliJ IDEA recommended)

### Running the Game

1. Clone this repository:
```
git clone https://github.com/Ishrar2019331104/Sneaky.git
```
2. Open the project in IntelliJ IDEA or your preferred Java IDE
3. Build and run the `Main.java` file in the `Main` package

## Game Development

The project was made by me and [mmmim24](https://github.com/mmmim24) for our Java project during our undergrad 2nd year. 

## Future Improvements

- Additional word puzzles and levels
- Score system based on completion time
- More interactive game elements
- Customizable difficulty settings
