# Requirements Analysis Template

## (1) Input
**Format** <br>
(e.g.) Single line with comma-separated values

**Method** <br>
(e.g.) Console.readLine(), BufferedReader, Scanner

**Sample** <br>
```
A,B,C
```

**Rules** <br>
(e.g.) Must be unique, should be numbers, no empty

<br>

## (2) Output
**Format** <br>  
(e.g.) Single line string, multiple lines, integer, etc.  

**Method** <br>  
(e.g.) Console output, return from method, etc. 

**Sample** <br>
```
B
```

**Rules** <br>  
(e.g.) Sorted alphabetically, 2 decimal places, no extra spaces, etc.

<br>

## (3) Execution Flow
- `Quick & Rough Plan`
- just to make the program run
- refactoring comes later
- Example
  ```
  1. Read input
  2. Parse input
  3. Validate input
  4. Process logic
  5. Output result
  ```

<br>

## (4) Must-Use Functions or Classes
- Functions/utilities are required
  - [ ] Console.readLine()
    = camp.nextstep.edu.missionutils.Console

  - [ ] IllegalArgumentException()


  - [ ] pickNumberRange(start, end)
    = camp.nextstep.edu.missionutils.Randoms
    = e.g.,
      val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)    

<br>

## (5) Given Constraints & Rules
- 제약조건파악 (핵심만 먼저)
  1. Lotto클래스
    - 'numbers' must be priavte
    - Can not add field.
  2. Enum클래스 사용
  3. View와 핵심로직 분리해서 구현
  4. 단위 테스트 작성 (View는 테스트 안해도 됨)
  5. else문 지양
  6. 함수 15라인 이하
  7. SRP
  8. Inden 3 (Max)
  9. 사용X: System.exit()
  
- Business rules or edge conditions

<br>

## (6) Domain Objects
- Example
  - Car
    - name: String  
    - position: Int  
    - isMoving: Boolean

## (7) Time Allocation per Task
______________________________________________________________
| Task                        | Estimated Time | Actual Time |
|-----------------------------|----------------|-------------|
| Requirement Analysis        | 15 min         |             |
| Analyze I/O & Format        | 5  min         |             |
| Execution Flow Draft        | 10 min         |             |
--------------------------------------------------------------
| ApplicationTest Analysis    | 10 min         |             |
| Feature List Creation       | 10 min         |             |
--------------------------------------------------------------
| Basic I/O + Validation      | 20 min         |             |
| Implement Logic in main     | 60 min         |             |
| Basic Output Check          | 10 min         |             |
| Refactoring + Cleanup       | 90 min         |             |
| Test Writing & Polishing    | 30 min         |             |
--------------------------------------------------------------