import math

def gcdArrays(arr):
    n = len(arr)
    max_gcd = 1
    max_length = 0
    
    for i in range(n):
        current_gcd = arr[i]
        current_length = 1
        
        for j in range(i + 1, n):
            current_gcd = math.gcd(current_gcd, arr[j])
            current_length += 1
            
            if current_gcd > max_gcd:
                max_gcd = current_gcd
                max_length = current_length
            elif current_gcd == max_gcd and current_length > max_length:
                max_length = current_length
                
    return [max_gcd, max_length]

# Example usage:
n = 7
arr = [3,6,4]
result = gcdArrays(arr)
print(result)  # Ou