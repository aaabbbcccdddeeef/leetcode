from bisect import bisect
from collections import Counter

n = int(input())
cnt = Counter()
res = 0
for i in range(n):
    op, val = [int(o) for o in input().split()]
    if op:
        lst = list(cnt)
        target = bisect(lst, val)
        if target < len(lst) and lst[target] > val:
            res += 1
            cnt[lst[target]] -= 1
            if cnt[lst[target]] == 0:
                del cnt[lst[target]]
    else:
        cnt[val] += 1
print(res)
