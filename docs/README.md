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
        
         


## (2) Execution Flow & Feature List based on the Execution Flow
- OutputView: Please enter the purchase amount.
- Read InputView(1): price
    - Validate
        - 숫자 맞는지 (하나라도 문자가 들어있으면 안됨)
        - 1000원 단위 (나눠지는지)
        => "형식 맞지 않을 경우 [ERROR]처리"

- OutputView: \n
- OutputView: You have purchased 15(= nTickets) tickets.

    - Calc
        - price로 몇개(nTickets) 살 수 있는지 체크

    - RandomGenerate
        - repeat(nTickets) -> 랜덤 6자리 숫자 생성 -> 출력 -> 저장
        - 규칙
            6개 생성해야함
            서로 겹치면 안됨
            오름차순 정렬

- OutputView: \n
- OutputView: Please enter last week's winning numbers.
- Read InputView(2): 6 digits from User
    - Validate
        - 6개 맞는지
        - 숫자 맞는지
        - 겹치는거 없는지
        - 범위가 1-45 맞는지

- OutputView: \n
- OutputView: Please enter the bonus number.
- Read InputView(3): 1 bonus number
    - Validate
        - 1개 맞는지
        - 숫자 맞는지
        - 범위가 1-45 맞는지

- Calc
    - 입력 받은 숫자와 저장된 숫자가 몇개 같은지 체크
    - (1등 - 5등) // 각각의 매칭 규칙에 맞게 확인 후 결과 저장

- OutputView: \n
- OutputView: Winning Statistics
    - 아래 형식에 맞는 결과 출력

---
3 Matches (5,000 KRW) – 1 tickets
4 Matches (50,000 KRW) – 0 tickets
5 Matches (1,500,000 KRW) – 0 tickets
5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets
6 Matches (2,000,000,000 KRW) – 0 tickets
Total return rate is 33.3%.

## (3) Implement Features (Build the Prototype)

- [ ] : Implement (1) Input & Output
- [ ] : Implement (2) Execution
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