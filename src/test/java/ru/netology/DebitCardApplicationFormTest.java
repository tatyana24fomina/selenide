package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardApplicationFormTest {
    private String fullName = "Иванов Сергей Петрович";
    private String number = "+79996665544";

    @Test
    void shouldCheckValidData() {
      open("http://localhost:9999/");
      $("#root > div > form > div:nth-child(1) > span > span > span.input__box > input").setValue(fullName);
      $("#root > div > form > div:nth-child(2) > span > span > span.input__box > input").setValue(number);
      $("#root > div > form > div:nth-child(3) > label > span.checkbox__box").click();
      $("#root > div > form > div:nth-child(4) > button").click();

      String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
      String actual = $("#root > div > div > p").text();

        Assertions.assertEquals(expected, actual);
    }


}
