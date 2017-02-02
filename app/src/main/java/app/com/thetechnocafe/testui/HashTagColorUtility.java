package app.com.thetechnocafe.testui;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

/**
 * Created by gurleensethi on 02/02/17.
 */

public class HashTagColorUtility {
    private static HashTagColorUtility sInstance;

    //Singleton class
    private HashTagColorUtility() {

    }

    //Instance method
    public static HashTagColorUtility getInstance() {
        if (sInstance == null) {
            sInstance = new HashTagColorUtility();
        }
        return sInstance;
    }

    /**
     * Change the color of all the hash-tags(#) with the words next to it
     * to the specified color and return the spannable string
     *
     * @param sentence String that contains the hash-tags(#)
     * @param color    Color to be given to the hash-tags(#)
     */
    public SpannableString colorHashTags(String sentence, int color) {
        SpannableString spannableString = new SpannableString(sentence);

        //Find all the has-tags(#) in the sentence
        for (int count = 0; count < sentence.length(); count++) {
            //Find the position where hash-tag(#) starts
            if (sentence.charAt(count) == '#') {
                //Get the position where the word with the hash-tag(#) ends
                for (int i = count; i < sentence.length(); i++) {
                    if (sentence.charAt(i) == ' ' || i == sentence.length() - 1) {
                        //Change the color of the hash-tag(#) and the word next to it
                        spannableString.setSpan(new ForegroundColorSpan(color), count, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        //Move the count to end of the word
                        count = i;
                        break;
                    }
                }
            }
        }

        return spannableString;
    }
}
