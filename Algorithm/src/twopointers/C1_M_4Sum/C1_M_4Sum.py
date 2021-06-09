def quadruplets(arr, target):
  arr.sort()
  res = []
  for i in range(len(arr) - 3):
    if i > 0 and arr[i] == arr[i - 1]:
      continue
    for j in range(i + 1, len(arr) - 2):
      if j > i + 1 and arr[j] == arr[j - 1]:
        continue
      pair(arr, target, i, j, res)
  return res

def pair(arr, target, first, second, res):
  left = second + 1
  right = len(arr) - 1
  while left < right:
    sum = arr[first] + arr[second] + arr[left] + arr[right]
    if sum == target:
      res.append([arr[first], arr[second], arr[left], arr[right]])
      left += 1
      right -= 1
      while left < right and arr[left] == arr[left - 1]:
        left += 1
      while left < right and arr[right] == arr[right + 1]:
        right -= 1
    elif sum > target:
      right -= 1
    else:
      left += 1

def main():
  print(quadruplets([4,1,2,-1,1,-3], 1))

main()