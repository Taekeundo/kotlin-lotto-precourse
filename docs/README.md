# Project Plan & Checklist

## (0) Project Workflow
 1. Set-up the project
 2. Execution Flow
 3. Define `Feature List` based on Execution Flow
 4. Implement Features → Build the prototype
 5. Testing → Ensure normal and edge cases work correctly
 6. Refactoring → Improve structure after ensuring stability
 7. Finalization → Polish and clean up, then prepare for submission





## (1) Setup & Project Initialization
- [✅] : Clone repository (forked project)
- [✅] : Verify that project runs properly `./gradlew clean test`
- [✅] : Setup basic folder and package structure
- [✅] : Make the initial commit<br>
        'chore(project): verify gradle test env runs'
        
         



## (2) Execution Flow
```
main()
├── Ask input(1) (e.g., names)
├── Get input
├── Validate input
│
├── Ask input(2) (e.g., number of rounds)
├── Get input
├── Validate input
│
├── Generate initial game state
├── Loop for N rounds
│     ├── Move logic (e.g., random check, calc)
│     └── Store round result snapshot
│
├── Determine winner(s)
│
├── Process final result
└── Print output
```

### STEP 1. INPUT
- read raw input(s) from user
- parse if needed (e.g., split, trim, convert)
- validate each input (type, range, format, rule)

### STEP 2. INIT
- create initial state/data structure based on input
- initialize domain objects or configuration if needed

### STEP 3. PROCESS / LOOP
- repeat or iterate as required by the problem
    - apply logic per iteration (e.g., rule check, update state)
    - track intermediate result if necessary

### STEP 4. FINALIZE
- process final result (e.g., filter, calculate, find max/min)
- resolve edge cases (e.g., tie, multiple result candidates)

### STEP 5. OUTPUT
- format and display result
- show error messages if applicable

### Flow
1. OutputView<br>
   "Enter the names of the cars (comma-separated):"

2. InputView (CarNames <List>)<br>
   e.g.) "jason, ja, j"

   -> Validate Input(1)
   ```
    Max length: 5 letters
    Duplication X
    Empty X
   ```

3. OutputView<br>
   "How many rounds will be played?"

4. InputView (nMove <Int>) <br>
   e.g.) 5

  -> Validate Input(2)
    ```
    Only Integer
    Must be over 0
    ```

5. OutputView<br>
   "\n"

6. Service: generate & save
   1. Loop (Each round)
   2. generate Random number 
      If) Over 4 -> go
      Else) -> Not go
   3. Save each round result
      RoundResult <List>
   
    ```
    { carName: jason, position: 2 }
    { carName: ja, position: 1 }
    { carName: j, position: 3 }
   ```

7. Service: Calc <br>
   Calculate winner -> Comparing final result.

   !! Handling Co-winner !!

8. OutputView <br>
   Print loop for each round result as many as "nMove" times.

        Race Results
        jason : -
        ja : -
        j : -

9. OutputView <br>
   "\n"

10. OutputView <br>
   "Winners : jason"

11. Error handling
    - Invalid "carName"
    - Invalid "nMove"





## (3) Feature List based on the Execution Flow

### 1. Input & Output
- [ ] Show message: "Enter the names of the cars (comma-separated):"
- [ ] Receive car names and parse them
- [ ] Validate car names (length, duplicate, empty)

- [ ] Show message: "How many rounds will be played?"
- [ ] Receive number of rounds
- [ ] Validate number of rounds (integer, > 0)

### 2. Race Execution
- [ ] Run race for N rounds
- [ ] For each car, generate random number and decide move
- [ ] Save race result per round
- [ ] Print race result after each round

### 3. Result Calculation
- [ ] Calculate winners based on maximum moves
- [ ] Handle co-winners

### 4. Final Output
- [ ] Show winner(s)

### 5. Exception Handling
- [ ] Show error messages for invalid car names
- [ ] Show error messages for invalid number of rounds





## (4) Implement Features (Build the Prototype)

- [ ] : Implement (1) Input & Output
- [ ] : Implement (2) Race Execution
- [ ] : Implement (3) Result Calculation 
- [ ] : Implement (4) Final Output
- [ ] : Implement (5) Exception Handling
- [ ] : Ensure all flows are working.





## (5) Testing
### Goal
- Confirm stability and safety before starting refactoring

### [ Basic Testing ]
- [ ] : Test basic cases. (normal scenarios)
- [ ] : Test edge cases. (e.g., empty, invalid, special conditions)
- [ ] : Test invalid inputs -> ensure proper error handling.
- [ ] : Confirm that no critical errors occur during feature usage.
- [ ] : Create TDD file for core features.

### [ Automated Testing ]
- [ ] : Run `./gradlew clean test`
- [ ] : Perform final test on the website submission page.





## (6) Refactoring Plan

### [ Guidelines ]
- [ ] : Apply SRP
- [ ] : Improve readability
- [ ] : Remove duplicated logic
- [ ] : Clean code (limit depth)
- [ ] : Apply naming conventions (formatting)
- [ ] : Apply MVC or DDD

### [ Domain ]
- [ ] : Make sure each entity has a clear and simple purpose.
- [ ] : Represent core domain concepts (Car, Race, etc.).

### [ Service ]
- [ ] : Implement business logic (calc, search, etc.).
- [ ] : Use domain models to process and return meaningful results.

### [ Controller ]
- [ ] : Handle user input and request flow only.
- [ ] : Delegate logic to services. (Should)
- [ ] : Connect view and service layers.

### [ View ]
- [ ] : InputView  - Handle user input
  - 입력'만' 담당 -> 가공, 검증 X
- [ ] : OutputView - Display results and errors
  - 출력'만' 담당 ->  가공, 검증 X

### [ Support ]
- [ ] : Provide utility(= helper) functions that assist processing but not part of core domain or business logic 
- [ ] : Parser - Convert raw input to structured data (e.g., split, trim)
- [ ] : Validator
  - Ensure input validation (e.g., Check empty name, max length, Type)
  - The role of a validator is to !! "only check" !!
  - 오직 검사만! 값을 변형하거나 가공하거나 리턴하지 않아야 SRP가 지켜진다.
  



   
## (7) Finalization & Submission

### [ Review ]
- [ ] : Run `./gradlew clean test` <All tests pass>
- [ ] : Verify edge case handling and exceptional cases
- [ ] : Perform final test on the website submission page.
- [ ] : Update README
- [ ] : Create PR for submission