
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class GujaratiTranslation {
  public static void main(String... args) throws Exception {
    // Instantiates a client
	  com.google.cloud.translate.Translate translate = TranslateOptions.newBuilder().setApiKey("AIzaSyDKak7gwe4TU71AhYRv16I22JDXXu3Ysr4").build().getService();

    // The text to translate
    String text = "Hello";

    // Translates some text into Russian
    Translation translation = translate.translate(
      text,
      TranslateOption.sourceLanguage("en"),
      TranslateOption.targetLanguage("gu")
    );

    System.out.printf("Text: %s%n", text);
    System.out.printf("Translation: %s%n", translation.getTranslatedText());
  }
}
