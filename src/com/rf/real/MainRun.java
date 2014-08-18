package com.rf.real;

import java.util.ArrayList;

public class MainRun {

    @SuppressWarnings("static-access")
    public static void main(String args[]) {

        String traindata = "Data.txt";
        String testdata = "Test.txt";
        int numTrees = 100;

        DescribeTrees DT = new DescribeTrees(traindata);
        ArrayList<int[]> Input = DT.CreateInput(traindata);
        int categ = 0;

        DescribeTrees DTT = new DescribeTrees(traindata);
        ArrayList<int[]> Test = DTT.CreateInput(testdata);

        for (int[] Input1 : Input) {
            if (Input1[Input1.length - 1] < categ) {
            } else {
                categ = Input1[Input1.length - 1];
            }
        }

        RandomForest RaF = new RandomForest(numTrees, Input, Test);
        RaF.C = categ;
        RaF.M = Input.get(0).length - 1;
        RaF.Ms = (int) Math.round(Math.log(RaF.M) / Math.log(2) + 1);
        RaF.Start();

    }
}
