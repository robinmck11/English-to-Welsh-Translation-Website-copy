package tests;

import database.RemoveRecord;

/**
 * Created by robin on 21/03/2017
 */

public class RemoveRecordTester
{
    public static void main(String[] args)
    {
        RemoveRecord rR = new RemoveRecord();

        rR.removeRecord("student","username", "student2");
    }
}
