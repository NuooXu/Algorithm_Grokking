def findAnagrams(s, patten):
  start, match = 0, 0
  p = {}
  result = []

  for c in patten:
    if c not in p:
      p[c] = 0
    p[c] += 1
  
  for end in range(0,len(s)):
    rc = s[end]
    if rc in p:
      p[rc] -= 1
      if p[rc] == 0:
        match +=1
    
    if match == len(p):
      result.append(start)
    
    if end >= len(patten) - 1:
      lc = s[start]
      start += 1
      if lc in p:
        if p[lc] == 0:
          match -= 1
        p[lc] += 1 
  
  return result

def main():
  print(findAnagrams("ppqp", "pq"))

main()