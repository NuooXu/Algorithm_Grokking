def square(arr):
  start, end = 0, len(arr) - 1
  res = [0 for x in range(len(arr))]
  cur = len(arr) -1
  while start <= end:
    left = arr[start] * arr[start]
    right = arr[end] * arr[end]
    if left > right:
      res[cur] = left
      start += 1
    else:
      res[cur] = right
      end -= 1
    cur -= 1
  return res


def main():
  print(str(square([-2,-1,0,2,3])))

main()