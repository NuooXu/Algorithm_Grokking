def findAvg(k, arr):
  result = []
  sum, start = 0.0, 0
  for end in range(len(arr)):
    sum += arr[end]
    if end >= k - 1:
      result.append(sum / k)
      sum -= arr[start]
      start += 1
  return result

def main():
  result = findAvg(5, [1,3,2,6,-1,4,1,8,2])
  print("average subarray of size k is:" + str(result))

main()