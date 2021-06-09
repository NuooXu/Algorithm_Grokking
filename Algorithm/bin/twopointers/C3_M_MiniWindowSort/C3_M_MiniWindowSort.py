import math

def miniWindow(arr):
  low, high = 0, len(arr) - 1
  while low < len(arr) - 1 and arr[low] <= arr[low + 1]:
    low += 1
  if low == len(arr):
    return 0
  while high > 0 and arr[high] >= arr[high - 1]:
    high -= 1
  if high == 0:
    return len(arr)
  
  minNum = math.inf
  maxNum = -math.inf
  for k in range(low, high + 1):
    minNum = min(minNum, arr[k])
    maxNum = max(maxNum, arr[k])
  
  while low > 0 and arr[low - 1] > minNum:
    low -= 1
  while high < len(arr) - 1 and arr[high + 1] < maxNum:
    high += 1

  return high - low + 1

def main():
  print(miniWindow([1,2,5,3,7,10,9,12]))

main()