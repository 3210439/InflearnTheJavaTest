package me.whiteship.inflearnthejavatest;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기 assert")
    void create_new_study() {
        Study study = new Study(-10);
        assertNotNull(study);
        System.out.println("스터디 만들기");
        // 람다식을 사용하는 이유 -> 람다식을 사용하지 않고 스트링을 인자로 넘겨주게 되면
        // 비교 연산이 실패하든 성공하든 메시지에 있는 문자열 합치기 연산이 항상 실행될 수 있다.
        assertEquals(StudyStatus.DRAFT, study.getStatus(),
                ()->"스터디를 처음 만들면 " + StudyStatus.DRAFT +" 상태다.");
        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.");
        // assertAll 을 사용하지 않으면


    }

    @Test
    @DisplayName("잘못된 인원 넣을 시 에러 체크")
    void create_new_study_3() {
        assertThrows(IllegalArgumentException.class, () -> new Study(-10));

    }

    @Test
    @DisplayName("잘못된 인원 넣을 시 에러 체크 4")
    void create_new_study_4() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        String message = exception.getMessage();
        assertEquals("limit은 0보다 커야 한다.", message);
    }


    @Test
    @DisplayName("스터디 만들기 assert_all")
    void create_new_study_all() {
        Study study = new Study(-10);
        System.out.println("스터디 만들기 assert_all");

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                    () -> "스터디를 처음 만들면 " + StudyStatus.DRAFT +" 상태다."),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );

    }

    @Test
    @DisplayName("시간체크 테스트")
    void test_time() {
        assertTimeout(Duration.ofMillis(100), () -> {
           new Study(10);
           Thread.sleep(100);
        });
    }

    @Test
    @DisplayName("greaterThen example")
    void greaterThenTest() {
        Study actual = new Study(10);
        assertThat(actual.getLimit()).isGreaterThan(0);
    }

    @Test
    @Disabled
    void create1() {
        System.out.println("create1");
    }

    @Test
    void create_new_study_again() {
        System.out.println("create_new_study_again");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after Each");
    }


}