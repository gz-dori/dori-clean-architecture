# Getting Start
Spring Boot multi module boilerplate

## Architecture
<img width="668" alt="image" src="https://user-images.githubusercontent.com/55127012/220030726-2779b833-f7f8-4b5e-82dd-b271f7e6a053.png">

- [Clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) 를 참조했습니다.

## Tech Stack
### Language
- Kotlin 1.6 (Java Version 17)
### Serverside Framework
- [Spring Boot](https://spring.io/projects/spring-boot)
### Authentication, Authorization Framework
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
### Persistence Framework
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- 다이나믹 쿼리 생성을 위해 [QueryDSL](http://querydsl.com) 를 사용합니다.
### Test Framework
- 유닛 테스트를 위해 [Kotest](https://kotest.io/docs/framework/framework.html) 를 사용합니다.
- Fixture 생성을 위해 [Fixture Monkey](https://naver.github.io/fixture-monkey) 를 사용합니다.
- WebMvc 테스트를 위해 [rest-assured](https://rest-assured.io/) 를 사용합니다.
