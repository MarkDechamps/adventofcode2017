package be.md;

import java.util.ArrayList;
import java.util.List;

public class CalculateCircleNumber {
    public int circleFrom(int findMe) {
        List<Integer> offSets = generateListTo(findMe);

        for (int i = 0; i < offSets.size(); i++) {
            if(offSets.get(i) >=findMe)return i;
        }
        throw new IllegalArgumentException("Not found:"+findMe);

    }

    private List<Integer> generateListTo(int i) {
        List<Integer> result = new ArrayList<>();

        result.add(1);
        int top = 1;
        int lenthPrevSide = 1;
        while (top <= i) {
            int maxNum = lenthPrevSide * 4 + 4;
            maxNum += result.get(result.size()-1);
            result.add(maxNum);
            top = maxNum;
            lenthPrevSide = lenthPrevSide + 2;
        }

        return result;
    }
    public int maxNumForCircleWithItem(int findMe){
        List<Integer> offSets = generateListTo(findMe);

        for (int i = 0; i < offSets.size(); i++) {
            Integer nrAtIndex = offSets.get(i);
            if(nrAtIndex ==findMe)return findMe;
            if(nrAtIndex >findMe)return nrAtIndex;
        }
        throw new IllegalArgumentException("Not found:"+findMe);
    }
}
