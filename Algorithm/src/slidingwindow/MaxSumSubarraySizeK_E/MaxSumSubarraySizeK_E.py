def findMaxSumSubarray(k, arr):
  max_sum, sum, start = 0, 0 , 0
  for end in range(len(arr)):
    sum += arr[end]
    if end >= k - 1:
      max_sum = max(max_sum, sum)
      sum -= arr[start]
      start += 1
  return str(max_sum)    

def main():
  print("Max sum of subarray of size K :" + findMaxSumSubarray(3, [2,1,5,1,3,2]))

main()