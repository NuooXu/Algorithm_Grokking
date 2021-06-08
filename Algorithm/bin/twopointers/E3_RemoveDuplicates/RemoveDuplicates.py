def remove(arr):
  next = 1
  for cur in range(len(arr)):
    if arr[next - 1] != arr[cur]:
      arr[next] = arr[cur]
      next += 1
  return next

def main():
  print(remove([2,3,3,3,6,9,9]))

main()