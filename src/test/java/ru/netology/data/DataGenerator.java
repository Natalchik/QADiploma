package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

   public static String approvedCardNumber = "4444444444444441";
   public static String declinedCardNumber = "4444444444444442";
   public static String emptyCard = "";
   public static String zeroCard = "0000000000000000";
   public static String shortCardNumber = "1234";
   public static String invalidMonth = "1%";
   public static String falseMonth = "13";
   public static String emptyMonth = "";
   public static String zeroMonth = "00";
   public static String invalidYear = "2#";
   public static String pastYear = "20";
   public static String emptyYear = "";
   public static String zeroYear = "00";
   public static String invalidCvc = "аа";
   public static String emptyCvc = "";
   public static String invalidHolder = "Иван Иванов";
   public static String emptyHolder = "";
   public static String zeroHolder = "0000000";

   public static String getRandomCard() {
      Faker faker = new Faker();
      return faker.finance().creditCard();
   }

   public static String getMonth() {
      return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
         }

   public static String getYear(int shiftYears) {
      return LocalDate.now().plusYears(shiftYears).format(DateTimeFormatter.ofPattern("yy"));
   }


   public static String getRandomValidHolder() {
      Faker faker = new Faker(new Locale("en"));
      String name = faker.name().firstName();
      String surname = faker.name().lastName();
      return name + " " + surname;
   }

   public static String getRandomValidCvc() {
      Faker faker = new Faker();
      return faker.number().digits(3);
   }
  }