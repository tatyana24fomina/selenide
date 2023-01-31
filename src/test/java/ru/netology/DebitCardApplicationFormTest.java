package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardApplicationFormTest {

    @Test
    void shouldCheckValidData() {
        String fullName = "Иванов Сергей Петрович";
        String number = "+79996665544";
        open("http://localhost:9999/");
        $("[data-test-id='name'] input").sendKeys(fullName);
        $("[data-test-id='phone'] input").sendKeys(number);
        $("[data-test-id='agreement'] span").click();
        $("button").click();

        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        $("[data-test-id='order-success'] ").shouldBe(Condition.visible).shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

}
