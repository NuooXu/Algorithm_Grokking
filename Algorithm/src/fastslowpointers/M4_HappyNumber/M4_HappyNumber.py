def findNumber(num):
  slow, fast = num, num
  while True:
    slow = square(slow)
    fast = square(square(fast))
    if slow == fast:
      break
  return slow == 1

def square(num):
  sum = 0
  while num > 0:
    digit = num % 10
    sum += digit * digit
    num //= 10
  return sum

def main():
  print(findNumber(23))

main()