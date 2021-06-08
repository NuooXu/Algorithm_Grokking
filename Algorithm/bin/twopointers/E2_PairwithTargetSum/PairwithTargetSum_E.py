def pairTarget(arr, target):
  start, end = 0, len(arr) - 1
  res = [-1, -1]
  while start < end:
    sum = arr[start] + arr[end]
    if sum == target:
      res[0] = start
      res[1] = end
      return res
    elif sum > target:
      end -= 1
    elif sum < target:
      start += 1
  return res


def main():
  print(pairTarget([1,2,3,4,6], 6))

main()