n = int(input())
arr = [0]*100_010
max_right = 10
for i in range(n):
    l, r = input().split()
    arr[int(l)] += 1
    arr[int(r)+1] -= 1
    max_right = max(max_right, int(r)+1)
for i in range(1, max_right):
    arr[i] += arr[i-1]
print(arr.count(max(arr)), max(arr))
