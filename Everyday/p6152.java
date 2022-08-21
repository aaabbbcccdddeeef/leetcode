public class p6152 {
    static public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int needEng = initialEnergy, needExp = initialExperience;
        int curExp = initialExperience;
        int n = energy.length;
        for (int i = 0; i < n; ++i) {
            needEng -= energy[i];
            if (curExp <= experience[i]) {
                needExp += experience[i] - curExp + 1;
                curExp = experience[i] + 1;
            }
            curExp += experience[i];
        }
        System.out.println(needExp);
        return needExp - initialExperience + (needEng > 0 ? 0 : 1 - needEng);
    }
}
