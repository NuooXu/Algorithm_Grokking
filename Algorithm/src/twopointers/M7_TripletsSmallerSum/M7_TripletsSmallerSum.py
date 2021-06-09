def triplets(arr, target):
  arr.sort()
  count = 0
  for i in range(len(arr) - 2):
    count += pair(arr, target - arr[i], i + 1)
  return count

def pair(arr, target, left):
  right = len(arr) - 1
  count = 0
  while left < right:
    sum = arr[left] + arr[right]
    if sum < target:
      count += right - left
      left += 1
    else:
      right -= 1
  return count

def main():
  print(triplets([-1,0,2,3], 3))

main()