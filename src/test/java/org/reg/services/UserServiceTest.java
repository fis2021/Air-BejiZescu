package org.reg.services;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.*;
import org.reg.exceptions.PasswordIncorrectException;
import org.reg.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

class UserServiceTest {

    @AfterEach
    void tearDown() {
        UserService.getDatabase().close();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @Test
    @DisplayName("Database is initialized, and there are no users")
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-database";
        FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }


    @Test
    void customerIsAddedToDatabase() {
        UserService.addUser("user1","user1","Client","user1","user1","user1");
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user1 = UserService.getAllUsers().get(0);
        assertThat(user1).isNotNull();
        assertThat(user1.getUsername()).isEqualTo("user1");
        assertThat(user1.getPassword()).isEqualTo(UserService.encodePassword("user1","user1"));
        assertThat(user1.getRole()).isEqualTo("Client");
        assertThat(user1.geteMail()).isEqualTo("user1");
        assertThat(user1.getName()).isEqualTo("user1");
        assertThat(user1.getPhoneNumber()).isEqualTo("user1");
    }

    @TestOnly
    void administratorIsAddedToDatabase() {
        UserService.addUser("user2","user2","Travel Agent","user2","user2","user2","user2");
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user2 = UserService.getAllUsers().get(0);
        assertThat(user2).isNotNull();
        assertThat(user2.getUsername()).isEqualTo("user2");
        assertThat(user2.getPassword()).isEqualTo(UserService.encodePassword("user2","user2"));
        assertThat(user2.getRole()).isEqualTo("Travel Agent");
        assertThat(user2.geteMail()).isEqualTo("user2");
        assertThat(user2.getName()).isEqualTo("user2");
        assertThat(user2.getPhoneNumber()).isEqualTo("user2");
        assertThat(user2.getPersonalKey()).isEqualTo("user2");
    }

    @TestOnly
    void testUserCannotBeAddedTwiceAndPasswordShouldBeChecked() {
        assertThrows(PasswordIncorrectException.class, () -> {
            UserService.addUser("user1", "user1", "Client", "user1", "user1", "user1");
            assertEquals(UserService.checkUserDoesAlreadyExist("user1", "user1"), true);
            assertEquals(UserService.checkUserDoesAlreadyExist("user3", "user3"), false);
            UserService.checkUserDoesAlreadyExist("user1", "user2");
        });
    };
}

