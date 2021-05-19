import math

def smallest(s, arr):
  min_len = math.inf
  sum, start = 0, 0
  for end in range(0, len(arr)):
    sum += arr[end]
    while sum >= s:
      min_len = min(min_len, end - start + 1)
      sum -= arr[start]
      start += 1
  if min_len == math.inf:
    return 0
  else:
    return min_len
    
def main():
  print("Smallest subarray length: " + str(smallest(8, [3,4,1,1,6])))

main()