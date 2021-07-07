package BinarySearch;

public class binarySearch {
  public static int search(int[] arr, int key) {
    int start = 0, end = arr.length - 1;
    boolean isasc = arr[start] - arr[end];
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(arr[mid] == key) return mid;
      if(isasc){
        if(arr[mid] > key){
          end = mid - 1;
        }else{
          start = mid + 1;
        }
      }else{
        if(arr[mid] > key){
          start = mid + 1;
        }else{
          end = mid - 1;
        }
      }
    }
    return -1;
  }

  public static int ceiling(int[] arr, int key){
    int start = 0, end = arr.length - 1;
    if(key > arr[end]) return -1;
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(arr[mid] < key){
        start = mid + 1;
      }else if(arr[mid] > key){
        end = mid - 1;
      }else{
        return mid;
      }
    }
    return start;
  }

  public static int letterCeiling(int[] arr, int key){
    int start = 0, end = arr.length - 1;
    if(arr[start] > key || arr[end] <= key) return start;

    while(start <= end){
      int mid = start + (end - start) / 2;
      if(arr[mid] > key){
        end = mid - 1;
      }else{
        start = mid + 1;
      }
    }
    return arr[start];
  }
  //---------------------------------
  public static int[] range(int[] arr, int key){
    int[] result = new int[] {-1, -1};
    result[0] = rangeHelper(arr, key, false);
    if(result[0] != -1){
      result[1] = rangeHelper(arr, key, true);
    }
    return result;
  }

  public static int rangeHelper(int[] arr, int key, boolean findMaxIndex){
    int index = -1;
    int start = 0, end = arr.length -1;
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(arr[mid] > key){
        end = mid - 1;
      }else if(arr[mid] < key){
        start = mid + 1;
      }else if(arr[mid] == key){
        index = mid;
        if(findMaxIndex){
          start = mid + 1;
        }else{
          end = mid - 1;
        }
      }
    }
    return index;
  }

  //---------------------------------

  public static int minClose(int[] arr, int key){
    int start = 0, end = arr.length - 1;
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(arr[mid] < key){
        start = mid + 1;
      }else if(arr[mid] > key){
        end = mid - 1;
      }else{
        return mid;
      }
    }
    //at the end of the loop "start == end + 1"
    return -1;
  }

  public static int findMax(int[] arr){
    int start = 0, end = arr.length - 1;
    while(start < end){
      int mid = start + (end - start) / 2;
      if(arr[mid] > arr[mid + 1]){
        end = mid;
      }else{
        start = mid + 1;
      }
    }
    return arr[start];
  }

  //---------------------------------
  public static int bitonic(int[] arr, int key){
    int maxIndex = max(arr);
    int index = findIndex(arr, key, 0, maxIndex);
    if(index != -1){
      return index;
    }
    return findIndex(arr, key, maxIndex, arr.length - 1);
  }

  public static int max(int[] arr){
    int start = 0, end = arr.length - 1;
    while(start < end){
      int mid = start + (end - start) / 2;
      if(arr[mid] < arr[mid + 1]){
        start = mid + 1;
      }else{
        end = mid;
      }
    }
    return start;
  }

  public static int findIndex(int[] arr, int key, int start, int end){
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(arr[mid] == key){
        return mid;
      }else if(arr[mid] > key){
        end = mid - 1;
      }else if(arr[mid] < key){
        start = mid + 1;
      }
    }
    return -1;

  }
  //---------------------------------

  public static int challenge2(int[] arr, int key){
    int start = 0, end = arr.length - 1;
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(arr[mid] == key) return mid;

      if(arr[start] < arr[mid]){
        if(arr[start] < key && key < arr[mid]){
          end = mid - 1;
        }else{
          start = mid + 1;
        }
      }else if(arr[start] > arr[mid]){
        if(arr[mid] < key && key < arr[end]){
          start = mid + 1;
        }else{
          end = mid - 1;
        }
      }
    }
    return -1;
  }



}
