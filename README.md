<aside>
💡

4주차에서 완성한 FrontController 기반 MVC 구조를 Spring Boot 프로젝트로 전환하고, 트랜잭션을 적용하는 것을 목표로 합니다.

단순히 코드만 변경하는 것이 아닌, **4주차에서 직접 구현했던 것들을 Spring이 어떻게 대신해주는지** 흐름을 생각하면서 진행하세요!

</aside>


### 요구사항 0: jsp 경로 수정

---

<aside>
💡

모든 버튼 및 form action 경로에 `/front-controller` prefix 제거 

</aside>

ex) 
<img width="448" height="120" alt="스크린샷 2026-04-26 오전 3 33 53" src="https://github.com/user-attachments/assets/c21d15cd-03c4-4612-bcba-8d36dca5a022" />


### 요구사항 1: Controller 통합과 조합

---

<aside>
💡

이전 미션에서 개발한 Controller들은 각각 한 기능만 제공할 수 있었지만, 스프링에서는 Controller 클래스를 유연하게 하나로 통합하고 조합할 수 있다.

**같은 도메인(domain)에 대한 Controller는 하나의 Controller로 묶어주자.**

</aside>

- e.g., MemberDetailController, MemberFormController, … → MemberController
- 힌트
    
    `@RequestMapping`은 클래스 레벨에 적용할 수 있고, 메서드 레벨에도 적용할 수 있다.
    
    `@GetMapping`, `@PostMapping`, …
    
    `@RequestParam`
    

### 요구사항 2: Spring Bean 등록

---

<aside>
💡

Spring에서 각 Controller들과 Service를 인식하고 의존관계를 주입해줄 수 있도록 Spring Bean으로 등록하자. 특히 Spring이 자동으로 Controller들은 Spring MVC Controller로, Service는 Spring MVC Service으로 인식할 수 있도록 선언해주어야 한다.

</aside>

- 힌트
    
    `@Component` ⊂ `@Controller`, `@Repository` , `@Service`
    

### 요구사항 3: 의존관계 자동 주입 - 생성자 주입

---

<aside>
💡

각 Controller에 생성자를 통해서 의존관계를 자동으로 주입받을 수 있도록 선언하자. 이때 Lombok을 활용해 보자.

</aside>

- 힌트
  `@RequiredArgsConstructor`

### 요구사항 4: Transaction 적용

---

<aside>
💡

Service 계층에 트랜잭션을 적용해보자.

</aside>

- 힌트
    
    `@Transactional` , `@Transactional(readOnly=true)`
    

---

### ⚙️ 실행 방법

1. 이제 `WebServerLauncher` 대신 `Application`로 실행하면 된다. 
2. 브라우저에서 `http://localhost:8080/home` 으로 접속하여 테스트 

---

## 📦 제출 방식

### 1️⃣ 코드 제출

- Spring Boot 전환 코드

### 2️⃣ PR 작성

- PR 내용에 코드 설명 포함해서 제출
