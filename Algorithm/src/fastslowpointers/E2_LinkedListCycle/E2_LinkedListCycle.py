class Node:
  def __init__(self, value, next=None):
    self.value = value
    self.next = next

def cycle(head):
  slow, fast = head, head
  while fast is not None and fast.next is not None:
    slow = slow.next
    fast = fast.next.next
    if slow == fast:
      return True
  return False 



def main():
  head = Node(1)
  head.next = Node(2)
  head.next.next = Node(3)

  print(str(cycle(head)))

main()