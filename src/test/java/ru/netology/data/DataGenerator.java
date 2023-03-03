package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataGenerator {
   private DataGenerator() {
   }

   private static Faker faker = new Faker(new Locale("en"));

   @Value
   public static class CardInfo {
      public String cardNumber;
   }

   public static CardInfo approvedCard() {
      return new CardInfo("4444444444444441");
   }

   public static CardInfo declinedCard() {
      return new CardInfo("4444444444444442");
   }

   public static CardInfo emptyCard() {
      return new CardInfo("");
   }

   public static String randomCard() {
      String randomCard = faker.finance().creditCard();
      return randomCard;
   }

   public static CardInfo zeroCard() {
      return new CardInfo("0000000000000000");
   }

   public static CardInfo someSymbolsCard() {
      return new CardInfo("1234");
   }

   @Value
   public static class HolderInfo {
      public String holder;
   }

   public static String getRandomValidHolder() {
      String name = faker.name().firstName();
      String surname = faker.name().lastName();
      String randomName = name + " " + surname;
      return randomName;
   }

   public static String getInvalidHolder() {
      String holder = "Иван Иванов";
      return holder;
   }

   public static String getEmptyHolder() {
      String holder = "";
      return holder;
   }

   public static String getZeroHolder() {
      String holder = "0000000";
      return holder;
   }

   @Value
   public static class MonthInfo {
      public String month;
   }

   public static int getRandomValidMonth() {
      int month = faker.number().numberBetween(10, 12);
      return month;
   }

   public static MonthInfo getInvalidMonth() {
      return new MonthInfo("1%");
   }

   public static MonthInfo getFalseMonth() {
      return new MonthInfo("13");
   }

   public static MonthInfo getEmptyMonth() {
      return new MonthInfo("");
   }

   public static MonthInfo getZeroMonth() {
      return new MonthInfo("00");
   }

   @Value
   public static class YearInfo {
      public String year;
   }

   public static int getRandomValidYear() {
      int month = faker.number().numberBetween(23, 26);
      return month;
   }

   public static YearInfo getInvalidYear() {
      return new YearInfo("2#");
   }

   public static YearInfo getPastYear() {
      return new YearInfo("20");
   }

   public static YearInfo getEmptyYear() {
      return new YearInfo("");
   }

   public static YearInfo getZeroYear() {
      return new YearInfo("00");
   }

   @Value
   public static class CvcInfo {
      public String cvc;
   }

   public static int getRandomValidCvc() {
      int cvc = faker.number().numberBetween(111, 999);
      return cvc;
   }

   public static CvcInfo getInvalidCvc() {
      return new CvcInfo("аа");
   }

   public static CvcInfo getEmptyCvc() {
      return new CvcInfo("");
   }

   public static CvcInfo getZeroCvc() {
      return new CvcInfo("000");
   }
}