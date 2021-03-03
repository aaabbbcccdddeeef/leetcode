class Solution:
    def reorderSpaces(self, text: str) -> str:
        num = text.count(" ")
        lst = text.strip().split()
        if len(lst) is 1:
            return lst[0] + " "*num
        q, c = divmod(num, len(lst)-1)
        return (" "*q).join(lst) + " "*c