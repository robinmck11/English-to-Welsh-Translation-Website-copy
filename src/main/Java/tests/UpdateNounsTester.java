package tests;

import database.UpdateNouns;

/**
 * Created by robin on 21/03/2017.
 */
public class UpdateNounsTester
{
    public static void main(String[] args)
    {
        UpdateNouns updateNouns = new UpdateNouns();
        updateNouns.updateNouns("eng", "welsh", "english", "WELSH");
    }
}
