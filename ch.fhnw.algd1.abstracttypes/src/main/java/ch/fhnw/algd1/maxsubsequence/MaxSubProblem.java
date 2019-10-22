package ch.fhnw.algd1.maxsubsequence;

public class MaxSubProblem {

    public int maxSub(int[] data) {
        var lastLow = 0;
        var lastHigh = 0;
        var bestSequence = 0;
        var last = 0;
        for (var i = 0; i < data.length; i++) {
            var current = data[i];
            var next = last + current;
            if (last + current < lastLow) {
                lastLow = next;
                lastHigh = next;
            } else if (last + current > lastHigh) {
                lastHigh = next;
                if (bestSequence < lastHigh - lastLow) {
                    bestSequence = lastHigh - lastLow;
                }
            }
            last = next;
        }

        return bestSequence;
    }

    public int maxSubv3(int[] data) {
        var max = 0;
        for (var start = 0; start < data.length; start++) {
            var temp = 0;
            if (start == 0 || data[start - 1] < 0) {
                for (var end = start; end < data.length; end++) {
                    temp += data[end];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }

        }
        return max;
    }

    public int maxSubv2(int[] data) {
        var max = 0;
        for (var start = 0; start < data.length; start++) {
            var temp = 0;
            for (var end = start; end < data.length; end++) {
                temp += data[end];
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public int maxSubv1(int[] data) {
        var max = 0;
        for (var start = 0; start < data.length; start++) {
            for (var end = start; end < data.length; end++) {
                int temp = data[start];
                for (var index = start + 1; index <= end; index++) {
                    temp += data[index];
                }
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

}
